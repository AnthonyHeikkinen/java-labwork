/*
Problem: Addition
	The user inputs two strings which needs to be added to a string sum.

PRECONDITIONS
	Strings; tal1, tal2; Which contains only positive natural numbers.

POSTCONDITIONS
	A string; sum; which contains the sum of tal1 and tal2;

STEPS
	1. Determine the length of each tal.
	2. Determine the last position of each tal by subtracting 1 of the length.
	3. Start from the last position in each tal, while pos1 and pos2 is not equals to 0
	 3.1 Set number[1|2] for each tal[position]
	 3.2 Add number1 and number2, get sum.
	 3.3 Use modulus 10 on sum, save result to rest.
	 3.4 Use INT division (sum/10), save result to memory.
	 3.5 Add rest to front of the StringBuilder object.
	 3.6 Move from actual index to the next ( to the left )
	4. With different sized strings use seperate while-blocks to iterate and add remaining numbers.

	PSEUDOCODE

	Add ( tal1, tal2 )
	{
		svar = ""
		pos1 = tal1.length -1
		pos2 = tal2.length -1
		rest = 0
		memory = 0

		while ( pos1 >= 0 AND pos2 >= 0 )
		{
			number1 = tal1.charAtIndex(pos1) - 48
			number2 = tal1.charAtIndex(pos2) - 48

			number1 =+ memory;

			sum = number1 + number2
			rest = sum % 10
			memory = sum / 10
			svar = rest + svar

			pos1--
			pos2--
		}

		while ( pos1 >= 0 )
		{
			number1 = tal1.charAtIndex(pos1) - 48
			number =+ memory

			sum = number1
			rest = sum % 10
			memory = sum / 10
			svar = rest + svar

			pos1--
		}

		while ( pos2 >= 0 )
		{
			number2= tal2.charAtIndex(pos1) - 48
			number =+ memory

			sum = number2
			rest = sum % 10
			memory = sum / 10
			svar = rest + svar

			pos2--
		}
	}

Problem: Subtraction
	The user inputs two strings which needs to be subtracted and result presented in a string difference.

PRECONDITIONS
	Strings; tal1, tal2; Which contains only positive natural numbers AND where tal1 > tal2.

POSTCONDITIONS
	A string; difference; which contains the difference of tal1 and tal2;

STEPS
	1. Determine the length of each tal.
	2. Determine the last position of each tal by subtracting 1 of the length.
	3. Start from the last position in each tal, while pos1 and pos2 is not equals to 0
	 3.1 Set number[1|2] for each tal[position]
	 3.2 Subtract number1 with number2. Save to difference
	  3.2.1 IF number1 is smaller than number2, add number1 with 10, then subtract. Set borrowed = 1
	  3.2.2 IF number2 is smaller than (number1-borrowed), subtract (number1-borrowed) with number2. Set borrowed = 0;
	 3.3 Add result to front of the StringBuilder object.
	 3.6 Move from actual index to the next ( to the left )
	4. With different sized strings use seperate while-blocks to iterate and subtract remaining numbers.

	PSEUDOCODE

	Subtract ( tal1, tal2 )
	{
		svar = ""
		pos1 = tal1.length -1
		pos2 = tal2.length -1
		difference = 0
		borrowed = 0

		while ( pos1 >= 0 AND pos2 >= 0 )
		{
			number1 = tal1.charAtIndex(pos1) - 48
			number2 = tal1.charAtIndex(pos2) - 48

			number1 =- borrowed;
			if ( number1 < number2 )
			{
				number1 =+ 10
				difference = number1 - number2
				borrowed = 1
			} else {
				difference = number1 - number2
				borrowed = 0
			}

			svar = difference + svar

			pos1--
			pos2--
		}

		while ( pos1 >= 0 )
		{
			number1 = tal1.charAtIndex(pos1) - 48
			difference =- borrowed

			svar = difference + svar
			borrowed = 0

			pos1--
		}

	}


*/