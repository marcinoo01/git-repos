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
<img width="1015" alt="Screenshot 2022-09-18 at 17 57 03" src="https://user-images.githubusercontent.com/85891362/190916890-9f7f07a9-82fd-441c-9b81-63d102db354c.png">
<img width="1017" alt="Screenshot 2022-09-18 at 17 57 31" src="https://user-images.githubusercontent.com/85891362/190916895-f330fbaf-de04-4737-9ce0-3c1334915083.png">
# sample request not existing user
curl http://localhost:8080/api/v1/users/marcinoo013123 -H 'Content-type: application/json'
<img width="1015" alt="Screenshot 2022-09-18 at 17 58 10" src="https://user-images.githubusercontent.com/85891362/190916899-feb5cfba-8503-4398-b5bc-b9074bcef6c3.png">
