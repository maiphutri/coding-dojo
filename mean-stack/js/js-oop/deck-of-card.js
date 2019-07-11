class Card {
  constructor(suit, strRank, numRank) {
    this.suit = suit;
    this.strRank = strRank;
    this.numRank = numRank;
  }

  show() {
    console.log(`Card:\n\t suit: ${this.suit}\n\t strRank: ${this.strRank}\n\t numRank: ${this.numRank} `)
  }
}


class Deck {
  constructor() {
    this.deck = [];
    const suits = ["Clubs", "Hearts", "Spades", "Diamonds"]
    const strRanks = ["Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Jack", "Queen", "King"]

    for (let suit of suits) {
      let counter = 1;

      for (let strRank of strRanks) {
        let card = new Card(suit, strRank, counter);
        this.deck.push(card);
        counter++;
      }
    }
  }

  show() {
    console.log("Number of cards in the deck: " + this.deck.length);
    console.log(this.deck);
  }

  shuffle() {
    for (let i=0; i < this.deck.length; i++) {
      let rand = Math.floor(Math.random() * this.deck.length);
      let temp = this.deck[i];
      this.deck[i] = this.deck[rand];
      this.deck[rand] = temp;
      return this;
    }
  }

  reset() {
    let sortedDeck = this.deck.sort((a,b) => a.numRank - b.numRank);
    console.log(sortedDeck);
  }

  deal() {
    let rand = Math.floor(Math.random() * this.deck.length).toString();
    return this.deck.splice(rand, 1)
  }
  
  hand(number) {
    return this.deck.slice(0,number);
  }
}

class Player {
  constructor(name, hand) {
    this.name = name;
    this.hand = hand;
  }

  showHand() {
    console.log(this.hand)
  }

  takeCard(deck) {
    this.hand.push(deck.deal()[0])
  }

  discardCard(num) {
    this.hand.splice(num, 1)
  }
}

let deckofCard = new Deck(cards);
let handof5 = deckofCard.shuffle().hand(5);
let player1 = new Player("Tri", handof5);
player1.takeCard(deckofCard);
player1.showHand();
player1.discardCard(2);
player1.showHand();