-- PL/SQL Block to fetch loans due in the next 30 days and print reminders
DECLARE
    -- SYSDATE tracks the current operational database date time
    CURSOR c_due_loans IS
        SELECT c.customer_id, c.customer_name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Upcoming Loan Repayment Reminders ---');
    
    FOR r_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || r_loan.customer_name || 
                             ' (ID: ' || r_loan.customer_id || '), your payment for Loan ID: ' || 
                             r_loan.loan_id || ' is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.');
    END FOR;
END;
/