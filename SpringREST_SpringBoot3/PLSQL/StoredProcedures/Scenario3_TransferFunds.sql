CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN accounts.account_id%TYPE,
    p_dest_account_id   IN accounts.account_id%TYPE,
    p_amount            IN NUMBER
) AS
    v_source_balance accounts.balance%TYPE;
    insufficient_funds EXCEPTION;
BEGIN
    -- 1. Fetch the source account balance with a row-level lock for transactional safety
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account_id
    FOR UPDATE;

    -- 2. Check that the source account has sufficient balance
    IF v_source_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- 3. Deduct amount from the source account
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_source_account_id;

    -- 4. Credit amount to the destination account
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_dest_account_id;

    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_source_account_id || ' to Account ' || p_dest_account_id || '.');
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Rejected: Insufficient funds in source account ' || p_source_account_id);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Rejected: One or both of the account IDs provided do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed due to a system error: ' || SQLERRM);
END TransferFunds;
/