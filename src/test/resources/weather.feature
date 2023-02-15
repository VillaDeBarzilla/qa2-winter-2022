Feature: Weather forecast

  Scenario: Weather forecast for specific city
    Given city ID is: 52347
    When we are requesting weather forecast

    Then coordinates are:
      | latitude  | 39.31 |
      | longitude | -74.5 |

    And timezone information is:
      | timezone | America/New_York |
      | offset   | -18000           |

    And current weather data is:
      | time        | 1646318698 |
      | sunrise     | 1646306882 |
      | sunset      | 1646347929 |
      | temperature | 282.21     |
      | feels_like  | 278.41     |
      | pressure    | 1014       |
      | humidity    | 65         |
      | dew_point   | 275.99     |
      | ultraviolet | 2.55       |
      | clouds      | 40         |
      | visibility  | 10000      |
      | wind_speed  | 8.75       |
      | wind_deg    | 360        |
      | wind_gust   | 13.89      |

    And current cloud information is:
      | id          | 802             |
      | main        | Clouds          |
      | description | scatteredclouds |
      | icon        | 03d             |

    And minutely forecast is:
      | time          | 1646318700 |
      | precipitation | 0          |

    And hourly forecast is:
      | time        | 1646316000 |
      | temperature | 281.94     |
      | feels_like  | 278.49     |
      | pressure    | 1014       |
      | humidity    | 67         |
      | dew_point   | 276.16     |
      | ultraviolet | 1.49       |
      | clouds      | 52         |
      | visibility  | 10000      |
      | wind_speed  | 7.16       |
      | wind_deg    | 313        |
      | wind_gust   | 10.71      |
      | pop         | 0.03       |

    And hourly cloud information is:
      | id          | 803          |
      | main        | Clouds       |
      | description | brokenclouds |
      | icon        | 04d          |

    And daily forecast is:
      | time        | 1646326800 |
      | sunrise     | 1646306882 |
      | sunset      | 1646347929 |
      | moonrise    | 1646309880 |
      | moonset     | 1646352120 |
      | moon_phase  | 0.03       |
      | pressure    | 1016       |
      | humidity    | 55         |
      | dew_point   | 273.12     |
      | wind_speed  | 9.29       |
      | wind_deg    | 3          |
      | wind_gust   | 16.48      |
      | clouds      | 49         |
      | pop         | 0.25       |
      | rain        | 0.11       |
      | ultraviolet | 3.38       |

    And daily temperature information is:
      | day     | 281.63 |
      | minimum | 271.72 |
      | maximum | 282.21 |
      | night   | 271.72 |
      | evening | 277.99 |
      | morning | 280.92 |

    And daily feels like information is:
      | day     | 277.83 |
      | night   | 264.72 |
      | evening | 273.35 |
      | morning | 277.66 |

    And daily cloud information is:
      | id          | 500       |
      | main        | Rain      |
      | description | lightrain |
      | icon        | 10d       |

    And alert Nr. 1 received:
      | sender      | NWSPhiladelphia-MountHolly(NewJersey,Delaware,SoutheasternPennsylvania)                                                                                                                                                                                                                                                                                                                                                               |
      | event       | SmallCraftAdvisory                                                                                                                                                                                                                                                                                                                                                                                                                    |
      | start       | 1646344800                                                                                                                                                                                                                                                                                                                                                                                                                            |
      | end         | 1646380800                                                                                                                                                                                                                                                                                                                                                                                                                            |
      | description | ...SMALLCRAFTADVISORYREMAINSINEFFECTFROM5PMTHIS\nAFTERNOONTO3AMESTFRIDAY...\n*WHAT...Northwinds15to20ktwithgustsupto25ktandseas\n3to5ftexpected.\n*WHERE...CoastalwatersfromLittleEggInlettoGreatEgg\nInletNJout20nm,CoastalwatersfromGreatEggInletto\nCapeMayNJout20nmandCoastalwatersfromManasquanInlet\ntoLittleEggInletNJout20nm.\n*WHEN...From5PMthisafternoonto3AMESTFriday.\n*IMPACTS...Conditionswillbehazardoustosmallcraft. |

    And tags for an alert Nr. 1 are:
      | Sunny  |
      | Clouds |

    And alert Nr. 2 received:
      | sender      | NWSPhiladelphia-MountHolly(NewJersey,Delaware,SoutheasternPennsylvania)                                                                                                                                                                                                                                                                                                                                                                                                                                     |
      | event       | SmallCraftAdvisory                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
      | start       | 1646344800                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | end         | 1646380800                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | description | ...SMALLCRAFTADVISORYREMAINSINEFFECTFROM5PMTHIS\nAFTERNOONTO3AMESTFRIDAY...\n*WHAT...Northwinds15to20ktwithgustsupto25ktandseas\n3to5ftexpected.\n*WHERE...CoastalwatersfromLittleEggInlettoGreatEgg\nInletNJout20nm,CoastalwatersfromGreatEggInletto\nCapeMayNJout20nmandCoastalwatersfromManasquanInlet\ntoLittleEggInletNJout20nm.\n*WHEN...From5PMthisafternoonto3AMESTFriday.\n*IMPACTS...Conditionswillbehazardoustosmallcraft. |

    And tags for an alert Nr. 2 are:
      | Sunny  |
      | Clouds |

