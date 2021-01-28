Feature: Search Locations

  In order to enjoy my arrival on the new city,
  As a visitor
  I want to look know where a POI is located

  POI stands for Point Of Interest, it is a term used in cartography,
  for the choice to represent a particular feature, using an icon that
  occupies a particular point

  Scenario Outline: Search for a POI
    Given that <visitor> wants to search for a point of interest
      And he needs to know where <poi> is located
     Then he should be able to see <poi> on the map

    Examples: Points Of Interest in Berlin App

      | visitor   |      poi             |
      |  Berner   | Berliner Fernsehturm |
      |  Berner   | Brandenburger Tor    |

    Examples: Points Of Interest in London App

      | visitor   |      poi             |
      | Lodovico  | Covent Garden        |
      | Lodovico  | Piccadilly Circus    |

    Examples: Points Of Interest in Lisbon App

      | visitor   |      poi             |
      |  Lisbet   | Castelo de São Jorge |
      |  Lisbet   | Bairro Alto          |



