Feature: Validation of Ecommerce Login Api

Scenario: To validate the functionality of login api when invalid http method is used
	Given payload for login api with credentials "mehulanand10051993@gmail.com" and "Mesh@1992"
	When user calls "LoginApi" with "GET" request
	Then validate that the status code is 404
	And validate that the "Content-Type" is "text/html" 

Scenario: To validate the functionality of login api when only user email is provided with post method
	Given payload for login api with credentials "mehulanand10051993@gmail.com" and ""
	When user calls "LoginApi" with "POST" request
	Then validate that the status code is 400
	And validate that the "Content-Type" is "application/json"
	And validate the message "Password is required" is passed in the response body	

Scenario: To validate the functionality of login api when only user password is provided with post method
	Given payload for login api with credentials "" and "Mesh@1992"
	When user calls "LoginApi" with "POST" request
	Then validate that the status code is 400
	And validate that the "Content-Type" is "application/json"
	And validate the message "Email is required" is passed in the response body

Scenario: To validate the functionality of login api when incorrect email and correct password is provided with post method
	Given payload for login api with credentials "mehulanand@gmail.com" and "Mesh@1992"
	When user calls "LoginApi" with "POST" request
	Then validate that the status code is 400
	And validate that the "Content-Type" is "application/json"
	And validate the message "Incorrect email or password." is passed in the response body

Scenario: To validate the functionality of login api when correct email and incorrect password is provided with post method
	Given payload for login api with credentials "mehulanand10051993@gmail.com" and "Mesh"
	When user calls "LoginApi" with "POST" request
	Then validate that the status code is 400
	And validate that the "Content-Type" is "application/json"
	And validate the message "Incorrect email or password." is passed in the response body

Scenario: To validate the functionality of login api when valid credentials are used with post method
	Given payload for login api with credentials "mehulanand10051993@gmail.com" and "Mesh@1992"
	When user calls "LoginApi" with "POST" request
	Then validate that the status code is 200
	And validate that the "Content-Type" is "application/json"
	And validate the message "Login Successfully" is passed in the response body