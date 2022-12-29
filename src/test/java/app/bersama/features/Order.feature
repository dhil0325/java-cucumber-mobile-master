@order
Feature: Buyer Order

  @buyerorder @positive
  Scenario Outline: As a user i should be able to bid price product
    Given user navigate to login page
    * user login with "valid_credential2"
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

    @sellerorder @positive
    Scenario Outline: As a user i should be able to accept order
      Given user navigate to login page
      * user login with "valid_credential1"
      * user should be directed to profilepage
      Given user tap daftar jual saya
      Given user tap navigation list diminati and choose product want to accept
      When user tap button terima
      Then user see transaction frame "<doneTransaction>"

    Examples:
      | doneTransaction                               |  |
      | Yeay kamu berhasil mendapat harga yang sesuai |  |
#there is bug on update status on button status so i dont add for update status definition