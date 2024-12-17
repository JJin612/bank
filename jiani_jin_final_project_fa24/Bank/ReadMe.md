Bank management system
Role: ordinary user, bank administrator
Ordinary user: login, registration, account cancellation, modification of personal information, viewing account information, deposit, withdrawal, transfer, viewing details
Bank administrator: login, registration, modification of personal information, viewing account information, statistics

Create table:
    User table (id,card_no,password,real_name,sex,balance,time,birthday)
    Administrator table(id,username,password,real_name,sex,time,birthday)
    Detail table (id,user_id,type,to_user,time)

