CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Update the balance of all savings accounts by adding 1% to the current balance
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'Savings';

    DBMS_OUTPUT.PUT_LINE('Monthly 1% interest successfully processed for all Savings accounts.');
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Interest processing failed: ' || SQLERRM);
END ProcessMonthlyInterest;
/