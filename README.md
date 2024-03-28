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

---

## Solution

For this, I have created the following classes:
#### Overall Test Coverage Report
![image](https://github.com/amey1302/Poker-Hand-Ranking/assets/114746925/50ede70e-b742-4e7e-b55c-2282a0bd0a61)

---
### Package: org.amaap.ttp.pokerhand
---
#### Model
- **domain**
  - **Exception**: Contains all defined exceptions for data validations.
  - **validators**
    - **Card Validator**: Contains all validators for a card.
    - **Hand Validator**: Contains all validators for a hand.
  - **Card**
    - **State**
      - private Suit suit
      - private Rank rank
    - **Behaviour**
      - Smart Constructor
      - Getter and toString
  - **Hand**
    - **State**
      - private List<Card> cards
    - **Behaviour**
      - Smart Constructor
      - Getter
      - getStringRepresentation
  - **HandRank**: Enum
    - **State**
      - Royal_FLUSH,...,HIGH_CARD
      - Rank HighestCard
    - **Behaviour**
      - HandRank withHighestCard
  - **Rank**: Enum
    - **State**
      - private final String abbreviation
      - Rank from TWO("2"),...,ACE("A")
    - **Behaviour**
      - Constructor
      - Getter
  - **Suit**: Enum
    - **State**
      - private final String abbreviation
      - SPADE("S"), HEART("H"), CLUB("C"), DIAMOND("D")
    - **Behaviour**
      - Constructor
      - Getter

- **service**
  - **HandRankEvaluataor**
    - **Behaviour**
      - public static HandRank evaluateRanking(Hand hand)
      - boolean methods for all HandRankingCategories

#### Class: PokerManager
- **Behaviour**
  - public Card createCard(Suit,Rank)
  - public Hand assignCardToHand(List<Card>)
  - public HandRank evaluateHandRanking(Hand hand)
