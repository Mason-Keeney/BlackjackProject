# Blackjack Application

### Week 4 Weekend Project Skill Distillery

## Overview

The Blackjack Application takes a player through a round of Blackjack played against an automated dealer. The player is dealt a hand, and selects whether they want to Hit, Stay or Surrender. The goal is to either have the highest value hand without exceeding 21, or to get Blackjack (a hand of exactly 21). The cards are worth their number in value, and all face cards except for the Ace are worth 10. The Ace can be worth either 11 (hard) or 1 (soft), depending on the total value of your hand, in the current implementation only one Ace in a hand can be considered 'soft'. In addition to the Dealer and Player classes I created a contestant interface that allowed the game to cycle through both the Dealer and the Player easily to determine the winner based on hand value, or to cycle through the turns. The table is where the bulk of the code lies for decision making, seeing as the rules are set and the dealer behaviors are unchanging, this made the most sense to me.

## Technologies/Skills Used

* Java
* Eclipse
* Git
* GitHub
* Terminal

## Lessons Learned

This was one of the harder projects for me, and the first I decided not to chase stretch goals on. The game logic seemed simple at first, but translating that to code that consistently gave the desired result proved challenging. A few small mistakes I made in the early code, also made getting to the first working copy a challenge. I am proud, however, that when I did ask for help, I was told that the readability of the code made it relatively easy to troubleshoot. The TA and I were able to track down and repair the error in about 10 minutes. Any advice on how to further improve that is always welcome, or if anything stands out as "Why did he do this the hard way?". Even if you don't have the time to show me the easy way, just a pointer in the right direction and I will investigate an easier methodology. Thank you! 
