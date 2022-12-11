Feature: Practice on homework

  Scenario: ilgili sayfalara gidip assert yapma
    Given User should be on the login page
    When User should input login information
    Then User should see the profile options only three
      | Dashboard    |
      | Developers   |
      | Edit Profile |
  @ahmet
  Scenario: ilgili modulu doldurup verify etme
    Given User should be on the login page
    When User should input login information
    And User should go to My Profile
    And User should go to addExprience
    And ilgili kutulari doldur
    And add exprience a click yap
    Then Overview modulune dondugunu verify et

    Scenario:

#Kullanici https://www.krafttechexlab.com/login Links to an external site.adresine gider.
#    Gecerli kullanici kriterleri ile giris yapar.
#    Kullanici sayfanin en ust sag tarafinda yer alan Dashboard, Developers Edit Profile ve login olan
#     Kullanicinin adinin yazili oldugu basliklari gorur.
#            (Not: List kullanarak yapilacak)
#
#
#
#    HW 2
#
#    Kullanici https://www.krafttechexlab.com/login Links to an external site.adresine gider.
#    Gecerli kullanici kriterleri ile giris yapar.
#    MY Profile altinda bulunan Add Experience modulune gider.
#    Ilgili kutulari doldurur.
#    Add Experience button click eder.
#    Overview modulune dondugunu verify eder.


