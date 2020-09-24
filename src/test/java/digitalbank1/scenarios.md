## EX1
- register new user via UI without page objects
--> works only once because user will be already registered 
- delete user with UTIL API call

## EX2
- register user that already exists 
- check error message 
--> discuss how this can be reproducible test (e.g. create user via API before running test)

## EX3
- create page objects for registration testcases
- create and delete user via API 

## EX4
- create checking account via UI and deposit 5K 
- reuse the account from previous test, deduct 1K and check balance
- chain the 2 tests via dependency -> show that if something goes wrong in test1, then test2 is affected. 

## EX5 
- create user, account and deposit via API 
- test only that deduction works and check balance 
 
 