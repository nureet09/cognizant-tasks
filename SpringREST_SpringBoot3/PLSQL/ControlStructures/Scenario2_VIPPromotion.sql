-- PL/SQL Block to update IsVIP status flag to TRUE for accounts with a balance over $10,000
DECLARE
    CURSOR c_high_balance_customers IS
        SELECT customer_id, balance
        FROM accounts;
BEGIN
    -- Using a cursor FOR loop for cleaner layout syntax management
    FOR r_cust IN c_high_balance_customers LOOP
        IF r_cust.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'  -- Assuming IsVIP is stored as a VARCHAR2 or flag configuration
            WHERE customer_id = r_cust.customer_id;
            
            DBMS_OUTPUT.PUT_LINE('Promoted Customer ID: ' || r_cust.customer_id || ' to VIP status.');
        END IF;
    END FOR;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction rolled back due to error: ' || SQLERRM);
END;
/