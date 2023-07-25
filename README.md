# POKER PLANING SESSION APP

<hr>

- Application created using Java 17 with Spring Boot 3.		

- The application design is implemented with the Bootstrap framework and Thymeleaf template.

- Created an API design to cover all the detected user cases.

- H2 database for persistence and simulating the interaction with a relational database is used.

- Spring Boo Data JPA used for communication to DB.

<hr>

<hr>

> CONDITIONS:

**USER STORIES**

**<i>Feature: Session management</i>**

<i>Scenario</i>: New session
Given I want create a place to make a poker planning session
When I type a title
And select the deck type
And submit the form
Then I enter in a new poker planning session
And I have a link to invite to other people to join

<i>Scenario</i>: Enter session
Given I receive an invitation link to join in a poker planning session
And I navigate to it
When I type my name/nickname
And submit the form
Then I enter in the poker planning session
And I see the title of the session
And I able to see the user stories list to vote
And I able to see the members list joined in the session

<i>Scenario></i>: Destroy poker planning session
Given I'm in as poker planning session
And I want to destroy the session
When I push "Destroy Session" button
And double check my intend
Then All data are destroyed
And I'm redirected to a confirmation page

**<i>Feature: Votes management</i>**

<i>Scenario</i>: Start voting a user story
Given There are PENDING or VOTED user stories
When I push the button "Start" of the user story
Then the user story move to VOTING status
And Card/Vote options are enable to select for all the connected members

<i>Scenario</i>: Vote a user story
Given There is a user story in VOTING status
When I select a card/vote option for it
Then the user story "emitted votes" increase in 1
And I'm marked as vote emitted
And the other members are not able to see my vote

<i>Scenario</i>: Listen to the votation status
Given There is a user story in VOTING status
When someone emits a vote
Then all the members see who has emitted the vote
And number of emitted votes in the user story
But Nobody is able to see the value of the vote from another member.

<i>Scenario</i>: Finish voting a user story
Given There is a user story in VOTING status
When I push the button "Stop" of the user story
Then the user story move to VOTED status
And no more votes are accepted for the user story
And the votes of all members are revealed
And summary of voted values are shown in the user story

**<i>Feature: User stories management**</i>

<i>Scenario</i>: Add a user story
Given I'm in as poker planning session
And I want to add a user story
When I fill user story Id and description
Then The user story is added in the user story list

<i>Scenario</i>: Delete a user story
Given I'm in as poker planning session
And I want to delete a user story
And the user story is PENDING
When I push the option to delete the user story
Then the user story disappears from the user story list