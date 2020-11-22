Feature: SecurePay - Contact Us page

  Description: The purpose of this test is to navigate to Contact Us page of SecurePay and enter the data in the Contact Us form

  Scenario: User navigates to Contact Us page of SecurePay and enters the randomly generated Test Data in the Contact Us form

    Given User is on Google Search page
    When User searches for SecurePay on Google
    And User clicks on SecurePay website from the search results to navigate to SecurePay
    And User navigates to Contact Us page in the SecurePay website
    Then User fills the Contact Us form with the random data generated using a library
