# sign.c
>  Return 0 if number is 0
>  Return 1 if number is > 0
>  Return -1 if number is < 0



>!(any number except 0) gives 0
>!(0) gives 1

> **We have 3 cases**
1. **Positvie** (Ex. 1)
!(positive) gives 0 and so !!(positive) -> 1
And the MSB of a positive number is 0
On doing right shift 31 times on a positive number we get 0
so we return 1(!!positive) **OR** 0(right shift number by 31 times) -> **1**

2. **Negative** (ex. -5)
!(negative) gives 0 and so !!(negative) -> 1
And the MSB of a negative number is 1
On doing right shift 31 times on a negative number we get -1
so we return 1(!!negative) **OR** -1 -> **-1**

3. **Zero** 
!(0) -> 1 and so !!(0) -> 0
And the MSB of 0 is 0
On right shift 0 by 31 places we still get 0
So we return 0(!!0) **OR** 0(right shift value) -> **0**

***
***

#  fitbits.c

```
int fitsBits(int x, int n) {
  return 0;
}

```

* return 1 if x can be represented as an n-bit, two's complement integer.

> Examples: fitsBits(5,3) = 0, fitsBits(-4,3) = 1

**Approach**
* We can left shift the number by (32-n bits) and then right shift the result by (32-n) bits if it fits in n bits the number will not change
* On doing the left shift and right shift , we do xor on the number with the original number , if its the same it returns 0 and we send **Result of xor** +1 as response
* If the result of xor is a non zero number -> we send the **Result of xor** +1 as response
* in response we get 1 if its a fit and a non 1 number if its not a fit

***
***

# logicalShift.c

>What is the question asking?
* In C, using the right shift operator (>>) on a signed integer performs an arithmetic shift. This means it duplicates the sign bit (the very first bit) to preserve the negative/positive status of the number. If a number is negative (starts with 1), shifting it right fills the empty spaces with 1s.

* The question asks you to force a logical shift. A logical shift treats bits as raw data and always fills the empty spaces with 0s, completely ignoring whether the number is positive or negative.

* Example Breakdown
The question provides this exact example: logicalShift(0x87654321, 4) = 0x08765432

Here is exactly what that example means:

The Input (0x87654321):
The first hex digit is 8. In binary, 8 is 1000. Because the first bit is a 1, C treats this as a negative number.

Default C Behavior (x >> 4):
When C shifts this right by 4 spaces, it drags that starting 1 with it to keep the number negative. It fills the new empty space at the top with four 1s (1111). In hex, 1111 is F.
Default result: 0xF8765432

The Goal (Logical Shift):
You need to build a bitwise mask to erase those unwanted 1s at the top. You want them to be 0s (0000), which is 0 in hex.
Target result: 0x08765432

***
***

# bang.c
* The idea is that the MSB of a number and its opposite sign number is 1 and 0 of either of them. **Meaning** 5 and -5 will have MSB as 0 and 1 , -8 and 8 will have MSB as 1 and 0
* But 0 will have only 0 as MSB for both positive and negative

**Approach**
* Do OR on x and negative of x and shift the result right by 31 places . This will definitely give us -1 as result if x is anything other than 0. incase x is 0 we get 0
return the above result + 1


# conditional.c

> We have to make a ternary operator result function which takes 3 args (x,y,z) and returns y is x is true else returns z is x is false
* Approach we turn x which is a number zero any non zero
* we normalize x by using double bang which keeps 0 to 0 and any other number to 1
* If x is one we make a mask of 32 bits 11111.....111111 otherwise we make mask of 0000000.....0000000
* Now with mask we change the mask by doing and with y and we do the same AND operation with z but change the x to ~x in z case
* The last step is if all ones means y will be safe after **AND** but when we change x to ~x we get all zeros and hence z will be removed
* The exact opposite happens in x is all 0s then y is erased and z is preserved


# isPower2.c
**Things to do**
* (x & x-1) checks if its a single set bit in x or not , if there is a single bit the result will be 0 else nonzero
* Check if the number is positive by checking the MSB is 0 or 1
* Check if the number is not Zero by using double bang