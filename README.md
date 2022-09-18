# git-repos

Acceptance criteria:

As an api consumer, given username and header “Accept: application/json”, I would like to list all his github repositories, which are not forks. Information, which I require in the response, is:
Repository Name
Owner Login
For each branch it’s name and last commit sha

As an api consumer, given not existing github user, I would like to receive 404 response in such a format:
{

        “status”: ${responseCode}

        “Message”: ${whyHasItHappened}

}

Notes:
Please full-fill the given acceptance criteria, delivering us your best code compliant with industry standards.
Please use https://developer.github.com/v3 as a backing API
# sample request existing user
curl http://localhost:8080/api/v1/users/marcinoo01 -H 'Content-type: application/json'
![](../../Screenshot 2022-09-18 at 17.57.31.png)
![](../../Screenshot 2022-09-18 at 17.57.03.png)
# sample request not existing user
curl http://localhost:8080/api/v1/users/marcinoo013123 -H 'Content-type: application/json'
![](../../Screenshot 2022-09-18 at 17.58.10.png)