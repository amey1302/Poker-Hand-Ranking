# Poker Hand Ranking Extension

## Problem Statement

Modify the poker program to include the following new hand rankings:

- **Straight Flush**: All cards are in the same suit and in sequence.
- **Two Pair**: Two pairs of cards have the same rank.

The new hand rankings are:

- **Straight Flush**: All cards are in the same suit and in sequence.
- **Four of a Kind**: Four of the cards have the same rank.
- **Full House**: Three cards of one rank, the other two of another rank.
- **Flush**: All cards are in the same suit.
- **Straight**: All cards are in sequence (aces can be high or low, but not both at once).
- **Three of a Kind**: Three of the cards have the same rank.
- **Two Pair**: Two pairs of cards have the same rank.
- **Pair**: Two cards have the same rank.
- **High Card**: None of the above conditions are met.

### Modification:

The high card rule should return the highest card as well. For example, the hand ["S2" "D5" "C7" "ST" "HA"] should return "high-card-ace".

## Solution

For this, I have created the following classes:

### Overall Test Coverage Report
![image](https://github.com/amey1302/Poker-Hand-Ranking/assets/114746925/404f9406-ed52-4eb9-b059-dec485477f85)


---

### Package: org.amaap.ttp.pokerhand

#### Model

- **domain**
  - **Exception**: Contains all defined exceptions for data validations.
  - **validators**
    - **Card Validator**: Validates properties of a card.
    - **Hand Validator**: Validates properties of a hand.
  - **Card**
    - **State**
      - private Suit suit
      - private Rank rank
    - **Behaviour**
      - Smart Constructor: Creates a new Card object.
      - Getter and toString: Accesses and represents card properties.
  - **Hand**
    - **State**
      - private List<Card> cards
    - **Behaviour**
      - Smart Constructor: Creates a new Hand object.
      - Getter: Retrieves the list of cards.
      - getStringRepresentation: Generates a string representation of the hand.
  - **HandRank**: Enum
    - **State**
      - Royal_FLUSH,...,HIGH_CARD
      - Rank HighestCard
    - **Behaviour**
      - withHighestCard: Sets the highest card for a hand rank.
  - **Rank**: Enum
    - **State**
      - private final String abbreviation
      - Rank from TWO("2"),...,ACE("A")
    - **Behaviour**
      - Constructor: Creates a new Rank object.
      - Getter: Retrieves the abbreviation.
  - **Suit**: Enum
    - **State**
      - private final String abbreviation
      - SPADE("S"), HEART("H"), CLUB("C"), DIAMOND("D")
    - **Behaviour**
      - Constructor: Creates a new Suit object.
      - Getter: Retrieves the abbreviation.
  - **HandRankEvaluator**
    - **Behaviour**
      - evaluateRanking: Evaluates the hand ranking.
      - rankCount : method which returns rank count in the hand
      - suitCount : method which returns suit count in the hand

- **ranking**
  - **Flush**: Checks if all cards are in the same suit.
  - **RoyalFlush**: Checks for a royal flush hand.
  - **StraightFlush**: Checks for a straight flush hand.
  - **FourOfKind**: Checks for a four of a kind hand.
  - **FullHouse**: Checks for a full house hand.
  - **Straight**: Checks for a straight hand.
  - **ThreeOfKind**: Checks for a three of a kind hand.
  - **TwoPair**: Checks for a two pair hand.
  - **Pair**: Checks for a pair hand.
  - **HighCard**: Checks for a high card hand.
#### Class: PokerManager
- **Behaviour**
  - createCard: Creates a new card with specified suit and rank.
  - assignCardToHand: Assigns a list of cards to a hand.
  - evaluateHandRanking: Evaluates the hand ranking for a given hand.

