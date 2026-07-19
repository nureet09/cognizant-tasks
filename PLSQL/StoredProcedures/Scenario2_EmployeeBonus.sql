CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department      IN employees.department%TYPE,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Update the salary by adding the bonus percentage passed as a parameter
    UPDATE employees
    SET salary = salary * (1 + (p_bonus_percentage / 100))
    WHERE department = p_department;

    DBMS_OUTPUT.PUT_LINE('Applied a ' || p_bonus_percentage || '% bonus to all employees in the ' || p_department || ' department.');
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Bonus update transaction aborted: ' || SQLERRM);
END UpdateEmployeeBonus;
/