CREATE OR REPLACE PROCEDURE GET_DETAILS 
(
  EID IN NUMBER 
, SNAME OUT VARCHAR2 
, SPER OUT float 
) AS 
BEGIN
  select name,per into SNAME,SPER FROM student where id = EID;
  commit;
END GET_DETAILS;
