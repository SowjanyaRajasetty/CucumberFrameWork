#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@FlightBooking
Feature: Flight Booking using Make My trip application
Background: Launch the application

Given user launches the MMT application
  #@tag1
  #Scenario: Title of your scenario
  #Given I want to write a step with precondition
  #And some other precondition
  #When I complete action
  #And some other action
  #And yet another action
  #Then I validate the outcomes
  #And check more outcomes
  @FlightBookingwithoutLoggingin
  Scenario Outline: To book the flight online from the given input values
    Given Guest user Opens the online flight Booking application
    When the user chooses the "<From>" and "<To>"

    Examples: 
      | From    | To     |
      | Chennai | Odisha |

  @FlightBookingwithLogin
  Scenario Outline: To book the flight online from the given input values
    Given "<UserType>" logins into the online flight Booking application
    When the user chooses the "<From>" and "<To>"
    #Then validate the payment page

    Examples: 
     |UserType| From    | To     |
     |MMTUser | Chennai | Odisha |
