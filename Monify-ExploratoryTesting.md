Below presents the list of testcases of what should be tested in monefy application as part of exploratory testing.

* Left side menu validations [MEDIUM]
	1.The app should have correct name and logo
	2. Tapping the app should launch it and Home screen should be displayed.
	3. Tapping the left hamburger sign should allow user to select the type of accounts
	4. Tapping the left hamburger sign should allow user to select the duration of transaction
	5. User should be able to select search option while menu on the left side is open
	6. User should be able to select transfer button (Double-arrow) to make a new transfer
	7. Tapping the back button on new transfer screen should take user back to previous screen where left menu was open
	8. User should be able to select right side menu ( vertical elipsis) when left side menu button is already open
	9. Clicking the right side menu should hide the left side menu.
	10. User should be able to select different time window and choose custom one from using Choose date option
	
* New Transfer button validations [HIGH]
	1. Header should also display search, new expense and vertical elipsis button to select other options like settings.
	2. Tapping double arrow (new transfer) button should open new transfer screen.
	3. New transfer screen should display current date in format "Weekday, DD Month" along with calender sign on the left.
	4. Tapping the calender sign should allow user to select custom date from the calender menu.
	5. New transfer screen should have green colored input box to enter transaction amount
	6. Tapping the green colored bar should invoke onscreen numeric keyboard
	7. User should be able to perfom mathematical operations using "+,-,*,%" button present on onscreen numeric keyboard
	8. User should be able to enter different amount upto 2 decimal places
	9. New transfer screen should have Add note input
	10. User should be able to enter note/note+emoticon/emoticon in the note section.
	11. Numeric onscreen keyboard should have Add transfer button
	12. New transfer screen should allow user to select type of transfer "Cash/Payment card" to transfer from
	13. New transfer screen should allow user to select type of transfer "Cash/Payment card" to transfer to
	14. Keypad sign should open the on screen keyboard on new Transfer screen
	15. It should be possible to add new transfer transaction via Add Transfer button
	16. New transfer screen should have a "Back arrow button" to return to Home screen
	17. New transfer screen should be closed
	18. App Logo should be displayed on the left side of the header. Under the logo the current type of account should be displayed

* App Home screen validations [HIGH]
	1. Main screen should display current date in format "Weekday, DD Month"
	2. Verfiy "circle diagram" is built correctly with sign of currency
	3. Verfiy "circle diagram" is built correctly with expenses marked in red
	4. Verfiy "circle diagram" is built correctly with income marked in green
	5. Home screen should display different category around "circle diagram"
	6. Each category should have correct UI and should be clickable
	7. Tapping Category buttons should open "New expense" screen 
	8. New expense screen should have a "Back button" to return to Home screen
	9. New expence screen display current date in format "Weekday, DD Month"
	10. New expence screen should have active input of transaction ammount
	11. User should be able to clear input value using "backspace" button
	12. It should be possible to see transaction currency next to transaction ammount input
	13. It should be possible to select type of transaction "Cash/Payment card"
	14 .It should be possible to enter transaction ammount using the onscreen numeric keyboard
	15. Onscreen numeric keyboard should be displayed on New expense screen
	16. Zero amount should not be allowed to enter
	17. Negative amount should not be allowed to enter
	18. Input value should be validated
	19. Mathematical operators should not be allowed in note section [BUG]
	20. Mathematical operators should give user clear view of usage [BUG]
	21. User should be able to enter different amount upto 2 decimal places
	22. Tapping on the "Note" input displays inbuilt keyboard
	23. Inbuilt keyboard should be closed if user taps on green checkbox while typing note and note should become inactive.
	24. If note is active and inbuilt keyboard is open and user taps on onscreen keyboard then inbuilt keyboard should get closed [BUG]
	25. If note is active and inbuilt keyboard is open, then onscreen keyboard should become inactive to enter amount [BUG]
	26. New expense screen shoult have button ADD '[CATEGORY NAME]'
	27. Tapping on ADD button, if the transaction ammount is zero, highlights transaction ammount input in red
	28. Tapping on ADD button with valid TXN ammount and valid/empty note value creates "Expense transaction". New expense window should be closed.
	29. User should be able to cancel the TXN. Steps to replicate:
		a. Create valid expense
		b. After creating the transaction the pop-up message should appear. 
		c. The pop-up message should confirm the transaction amount and category. 
		d. There should be Cancel button in the pop-up message. 
		e. Cancel button deletes transaction. 
		f. Pop-up message disappears after 10 sec.
 
* Balance button validations [HIGH]
	1. Balance button should display current balance (positive/negative,with currency, upto 2 decimals places)
	2. Balance button should become red if overall balance is in negative
	3. Balance button should become green if overall balance is positive
	4. Tap on Balance button should display Balance section with detailed transaction details
	5. Balance section displays history of transactions of the selected time period
	6. Transactions list is displayed by Categories.
	7. Every Category has a total value of transactions found in this Category
	8. Tap on Category expands list of transactions with below details:
		a. Each transaction displays if it's debit or credit. 
		b. Every transaction in a list displays transaction amount with currency and the transaction date "DD Mon"
		c. Debit transactions should be marked in red
		d. Credit transactions should be marked in green
	9. Second tap on Balance button hides the Balance section
	10. Addition of expenses or income should update the balance button in real time.
	11. "Downward" arrow on the right side of the Balance button should sort the transaction based on category/duration

* -/+ buttons validations [MEDIUM]
	1. Tap on - button opens New expense screen.
	2. Tap on + button opens New income screen.
	3. New Income keyboard and amount entering mechanism should be similar to add trasfer/new expense scree
	4. Below should be the difference b/w new expense and new income
		a. After entering valid amount user and no/valid note user should be able to add category "Deposits, Salary, Savings","ADD+"
		b. Tapping ADD+ should take user to Pro-feature
		c. For new Expense, after entering valid amount user and no/valid note user should be able to add category which are displayed in home screen
		d. It should be impossible to Choose Category while the transaction ammount is zero for both income/expense screen
	5. User should be able to cancel the TXN for both income/expense screen. Steps to replicate:
		a. Create valid expense
		b. After creating the transaction the pop-up message should appear. 
		c. The pop-up message should confirm the transaction amount and category. 
		d. There should be Cancel button in the pop-up message. 
		e. Cancel button deletes transaction. 
		f. Pop-up message disappears after 10 sec.
	5. Balance button is updated after income transaction was created. Transaction is displayed in Balance history section.


* Right side menu validations [MEDIUM]
	1. Tapping on right side hamburger menu should display "Categories, Accounts, Currencies, Settings"
	2. Tapping on each menu item opens sub-menu items
	3. User should be allowed to enter submenu under different menu (pro feature)
	4. Tapping on different categories expands different category screen
	5. Edit category screen should allow user to delete category
	6. Edit category screen should allow user to rename category
	7. User should be able to merge categories using hamburger sign on indiviual category
	8. User should be able to enable/disable a particular category
	9. User changes should be saved automatically
	10. User should be able to change the category icon (pro feature)
	11. User should be able to close sub-category menu by clicking back button
	12. On updating the category user should be informed the same via pop message 
	13. User should be able to cancel the change by clicking cancel button on pop message 
	14. User should be able to create new account under Accounts sub menu
	15. User should be allowed to enter new account name
	16. User should be allowed to enter new currency (pro feature)
	17. User should be allowed to enter Initial account balance
	18. User should be allowed to enter Initial balance date
	19. User should be displayed with swipe button to decide whether new account balance should be included in the total balance.
	20. User should be allowed to enter new account icon
	21. User should be able to add new account using header button on the top right corner of the header
	22. Predefined text Name should appear in the Green text box
	23. User should not be able to create new account if no name has been provided. The text field should highlight in red on tapping ADD button
	24. User should not be able to create new account if no image has been selected. "Select an image" pop should appear.
	25.	On successful creation of new Account below should be displayed
		a. Pop up with message "New account was created" [BUG] 
		b. Cancel button deletes transaction. 
	26. User should be able to see new account created on left side menu under "All accounts"
	27. User should be able to delete account
	28. User should be able to edit account
	29. User should be able to merge account
	30. User should be able to enable/disable account
	32. Account submenu should also allow user to create transfer transaction
	33. Tapping on curriences takes user to pro feature
	34. User should be able to go to Settings via setting button
	35. Four submenu should be displayed "BALANCE","GENERAL SETTINGS", "SYNCHRONIZATION", "DATA BACKUP"

