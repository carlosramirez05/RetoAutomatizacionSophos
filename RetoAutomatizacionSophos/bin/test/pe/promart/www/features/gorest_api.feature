@Gorest_API
Feature: Sophos Challenge using Go rest
  An user wants to register using the Go rest API

  @Gorest @TestCase1
  Scenario Outline: Successful Case
  Narrative: Register an user with the Gorest API

    When an user create a register using his data
      | first_name | <first_name>|
      | last_name  | <last_name> |
      |  gender    | <gender>    |
      |  email     | <email>     |
      |  status    | <status>    |
    Then the user check the correctly create

    Examples:
      | first_name | last_name | gender | email      | status |
      | Carlos     | Ramirez  | male   | ce.ramirez0505@gmail.com | active |