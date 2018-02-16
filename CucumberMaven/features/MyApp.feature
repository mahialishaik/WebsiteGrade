Feature: AHC website Grade validation

  Scenario Outline: Test AHC website score before build
    Given open chrome website
    When provide the website name "<website Name>"
    Then check the score is less than or greated than "90"

    Examples: 
      | website Name            |
      | ALIGNMENTHEALTHPLAN.COM |
      | ALIGNMENTHEALTHCARE.COM |
