## EX1
- register new user via UI without page objects
--> works only once because user will be already registered 
- delete user with UTIL API call

## EX2
- register user that already exists 
- check error message 
--> discuss how this can be reproducible test (e.g. create user via API before running test)



1. 
- create API call to delete a specific user
- run above test again  

1. 
- create page objects for registration page
- test positive case 
- test negative case when user already exists 

1. 
 - Create user via API
 - create account via UI with 5K opening balance 
 - withdraw 1K via UI and verify resulting balance 
 - delete user via API 
 
 2. 
 - create user via API  
 - create account via API with 5K opening balance 
 - withdraw 1K via UI and verify resulting balance 
 - delete user via API 
 
 