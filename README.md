create or replace NONEDITIONABLE procedure getInfo(eid in varchar2 , ename out varchar2)
AS
BEGIN
select name INTO ename from emp where id=eid;
commit;
end;
