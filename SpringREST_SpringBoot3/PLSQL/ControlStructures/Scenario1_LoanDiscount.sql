-- PL/SQL Block to apply a 1% discount to loan interest rates for customers over 60
DECLARE
    -- Cursor to fetch relevant customer and loan details
    CURSOR c_eligible_customers IS
        SELECT c.customer_id, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
        
    v_cust_id       customers.customer_id%TYPE;
    v_loan_id       loans.loan_id%TYPE;
    v_current_rate  loans.interest_rate%TYPE;
BEGIN
    OPEN c_eligible_customers;
    LOOP
        FETCH c_eligible_customers INTO v_cust_id, v_loan_id, v_current_rate;
        EXIT WHEN c_eligible_customers%NOTFOUND;
        
        -- Apply a 1% absolute reduction or a 1% fractional discount based on database business rules.
        -- Here we subtract an explicit 1% from the rate (e.g., 8% becomes 7%).
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE loan_id = v_loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || v_loan_id || ' for Customer ID: ' || v_cust_id);
    END LOOP;
    CLOSE c_eligible_customers;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        IF c_eligible_customers%ISOPEN THEN
            CLOSE c_eligible_customers;
        END IF;
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error encountered: ' || SQLERRM);
END;
/