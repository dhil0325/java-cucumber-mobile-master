@order
Feature: Buyer Order

  @buyerorder @positive
  Scenario Outline: As a user i should be able to login
    Given user navigate to login page
    * user login with "valid_credential1"
    * user should be directed to profilepage
    * navigate to homepage and tap search field
    * input product search and click product
    * navigate to product page
    * tap button saya tertarik dan ingin nego
    When fill out bid price and tap button kirim
    Then see notification "<bidMessage>"

  Examples:
    | bidMessage                                |
    | Harga tawarmu berhasil dikirim ke penjual |