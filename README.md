# ILBPM9987L

This project contains solutions to different progcont exercises as per the requests of the instructor.

## Safety hazards

**May cause damage to eyes through prolonged or repeated exposure**

The main goal of these exercises is the algo part, so be warned: **no cleancode**

We were encouraged to try out different things, like fiddling around with StringBuilder::delete to circumvent reinstantiations,
or for specific constrained inputs we could use simple arrays instead of hashmaps,
or using exceptions to quickly jump back to a specific point etc.,
or to figure out whether some fancy language feature is slower than its C-style counterpart,
or doing some nasty things to ensure constant additional space need (like modifying arrays in-place).

## Homework

> ATTENTION: A pass on online judge does NOT imply a pass on Progcont reliably.

> ATTENTION: Progcont requires your class to be in default package (aka no package)

> ATTENTION: Progcont test are much more thorough than online judge

> ATTENTION: Progcont input and output formats are sometimes different from online judge.

> ATTENTION: Online judge requires your class to be package private(aka no visibility specifier) and be called Main.


My solutions focus purely on fun and not on efficiency.
When a nice closed form solution arose I used it, even if it meant bad performance.
(Even though the solution itself is O(1), if it uses sqrt, pow or something similar, 
then those mess up the actual time complexity, and they add the method calls' constant overhead.)

| Code | Exercise | Submission | Source |
| ---- |----- | ----------- | ------------- |
| A | [Searching for Nessie](https://progcont.hu/progcont/100386/?pid=11044) | [ddea4c5b](https://progcont.hu/submission/?id=ddea4c5b-649c-4988-971b-da03efb129ee) | [src](src/main/java/Nessie.java) |
| B | [The Snail](https://progcont.hu/progcont/100386/?pid=573) | [ade6fa30](https://progcont.hu/submission/?id=ade6fa30-28ed-4908-bd37-8e5583118568) | [src](src/main/java/SnailConstO.java) |
| C | [In Braille](https://progcont.hu/progcont/100386/?pid=5797) | [cc84453a](https://progcont.hu/submission/?id=cc84453a-5453-4f76-a0d9-5f9b7312e980) | [src](src/main/java/BrailleDumb.java) |
| D | [Chessboard in FEN](https://progcont.hu/progcont/100386/?pid=10284) | [333cbdd1](https://progcont.hu/submission/?id=333cbdd1-cf4f-4fb3-9bf1-93b417149304) | [src](src/main/java/ChessboardInFEN.java) |
| E | [Bankrupt Baker](https://progcont.hu/progcont/100386/?pid=11308) | [09395749](https://progcont.hu/submission/?id=09395749-9f70-46c7-bbdd-a99d2b237b86) | [src](src/main/java/BankruptBaker.java) |
| F | [Bee](https://progcont.hu/progcont/100386/?pid=11000) | [3649c5ba](https://progcont.hu/submission/?id=3649c5ba-649d-42fc-8172-70acd105d81d) | [src](src/main/java/BeeClosedFormCached.java) |
| G | [Edit Distance](https://progcont.hu/progcont/100386/?pid=4898) | [77266814](https://progcont.hu/submission/?id=77266814-fa0b-4355-bbb2-530b0040ba43) | [src](src/main/java/EditDistanceDPTwoRowsOnly.java) |
| H | [Anagram](https://progcont.hu/progcont/100386/?pid=195) | [637e604f](https://progcont.hu/submission/?id=637e604f-3404-43a6-909c-45a24b383ffb) | [src](src/main/java/AnagramOrderNotPrecomputed.java) |
| I | [Oil Deposits](https://progcont.hu/progcont/100386/?locale=en&pid=195) | [5287de81](https://progcont.hu/submission/?id=5287de81-7219-40c4-8119-3768a669f7d6) | [src](src/main/java/OilDeposits.java) |
| J | [8 Queens chess problem](https://progcont.hu/progcont/100386/?pid=750) | [04a9043f](https://progcont.hu/submission/?id=04a9043f-6d46-42cf-a90a-4cd937cf93cb) | [src](src/main/java/QueensChessProblemProgcont.java) |
| K | [Shoemaker's problem](https://progcont.hu/progcont/100386/?pid=10026) | [8345e978](https://progcont.hu/submission/?id=8345e978-3d04-40da-9825-0dde6d246452) | [src](src/main/java/ShoemakersProblem.java) |
| L | [Points in Figures: Rectangles and Circles](https://progcont.hu/progcont/100386/?pid=477) | [b735d2c2](https://progcont.hu/submission/?id=b735d2c2-8db5-437a-a2a4-a4965fa7c7fd) | [src](src/main/java/RectanglesCirclesAndTriangles.java) |
| M | [Points in Figures: Rectangles, Circles, and Triangles](https://progcont.hu/progcont/100386/?pid=478) | [54fd27db](https://progcont.hu/submission/?id=54fd27db-fa79-4a7d-b694-aa8b07a1dee3) | [src](src/main/java/RectanglesCirclesAndTriangles.java) |
| X | [Ancient Messages](https://progcont.hu/progcont/100067/?pid=5130) | [6d0f4748](https://progcont.hu/submission/?id=6d0f4748-1e7f-4f11-a4f9-3d696a261dde) | [src](src/main/java/AncientMessages.java)