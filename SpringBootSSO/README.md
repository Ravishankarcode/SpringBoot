# Spring Boot Single Sign-on Example Application

# What is Single sign-on?

Single sign-on (or SSO) allow users to use a single set of credentials to login into multiple related yet independent web applications. SSO also includes not asking users to login again into application B if they have already logged into application A given that A and B use SSO. SSO is achieved by implementing a centralised login system that handles authentication of users and share that information with applications that need that data.

The most common example of SSO that most of us use is by Google. When you use login to any Google service, you are redirected to https://accounts.google.com for authentication. For example, if you go to gmail.com you will be redirected to https://accounts.google.com for login. Same is the case when you to try to sign in to Youtube. After successful authentication, users are redirected to the application.

The requirement for SSO is common in enterprises where different applications come into the system at different times . Some applications are developed by different business units in isolation or some come through acquisitions. Each system come packaged with their own identity systems. Having different identity systems not only make it difficult for end users to use the applications but it also makes it difficult for an enterprise to link multiple identities to a user so that they can view a user as a single customer. Having a centralised login system is the first step to gain better understanding of the end user.

# How does SSO authentication works?
This section is not talking about a specific SSO server implementation. We will cover that when we will look at Spring Security OAuth. In this section, we will understand the basic idea behind most SSO systems. Below is a diagram that depicts the SSO flow. We have two applications app1.com and app2.com. There is a centralised SSO server login.example.com.

![](images/sso.png)

This is what happens in the SSO flow:

1. A user goes to the app1.com for the first time. As user is not logged in, a login button is available to the user. User clicks the login button and user is redirected to the SSO server.
2. User enters credentials on the login page rendered by the SSO server. SSO server validates the credentials and generates a SSO token. SSO server sets the SSO token in the cookie for future login attempts by the user.
3. SSO server redirects user to the app1.com. In the redirect URL, it also appends SSO token as the query parameter.
4. app1.com saves the token in its cookie and change view to the logged in user. app1.com can get information about the user either by querying the SSO server or if token is a JWT token then it can get basic user information from the token itself.
5. Now, the same user tries to access app2.com. As an application can only access cookie for the same origin it has no knowledge that user is logged in to app1.com. So, user will still be shown login button on app2.
6. User clicks the login button and then user is redirected to the SSO server. SSO server sees that it already has a cookie set so it will immediately redirect the user to app2.com with SSO token appended in the URL as query parameter.
7. app2.com stores the token in the cookie and change its view to logged in user.

At the end of this process there will be three cookies set in the user browser each for app1.com, app2.com, and login.example.com domains.
