package GUI;

import java.util.Scanner;


    /**
     * Abstract class implementing the basic functionality of a console based
     * menu class. A menu can be created by sub-classing this class and implement
     * the abstract method doAction(option).
     *
     * The constructor of the sub-class must invoke the super-class constructor by
     * the instruction
     *
     *          super(“some header”, “menuoption1", "menuoption2");
     *
     * Note, that this instruction must be the first instruction of the sub-class
     * constructor.
     *
     * @author bhp
     */
    public abstract class Menu
    {
        // value used to exit the menu.
        // the value can be changed by the sub-class constructor.
        protected int EXIT_OPTION = 0;

        // The menu header text
        private String header;

        // The list of menu options texts.
        private String[] menuItems;

        /**
         * Abstract method stating what should be done, when a
         * menu option is selected.
         * The method must be overridden by the sub-class.
         * @param option the menu option that has been selected.
         */
        protected abstract void doAction(int option);


        /**
         * Creates an instance of the class with the given header text and
         * menu options.
         * @param header    The header text of the menu.
         * @param menuItems The list of menu items texts.
         */
        public Menu(String header, String... menuItems)
        {
            this.header = header;
            this.menuItems = menuItems;
        }

        /**
         * Executes the menu until the EXIT_OPTION has been selected.
         * This is an implementation of the Template Method design pattern.
         */
        public void run()
        {
            boolean done = false;
            while (!done)
            {
                showMenu();
                int option = getOption();

                if (option == EXIT_OPTION)
                {
                    done = true;
                }
                else {
                    doAction(option);
                }
            }
        }
        /**
         * Returns a valid menu-option input from the keyboard.
         * The method continues prompting for an option value, until
         * a valid option has been input.
         * @return A valid menu option.
         */
        private int getOption()
        {
            String input = null;
            int validOption = 0;
            while (input == (null)) {
                System.out.println("Please enter a valid input:");
                Scanner keyboard = new Scanner(System.in);
                input = keyboard.nextLine();
                try{
                    int option = Integer.parseInt(input);
                    if (option<=menuItems.length && option>=0)
                        return option;
                    else {
                        System.out.println("Please type in a valid number");
                        input = null;
                    }
                }
                catch (NumberFormatException nfe){
                    System.out.println("please type in a number");
                    input=null;
                }
            }
            return 0; // Dummy

        }

        /**
         * Prints out a console menu
         with a header text and a list
         * of menu options. The menu
         options will be assigned the numbers
         * from 1 to the number of
         options in the menu.
         */
        private void showMenu()
        {
            clear();
            System.out.println("******  " + header+ "  ******");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ": " + menuItems[i]);

            }
        }

        /**
         * Waits until the 'enter' key is pressed.
         */
        protected void pause()
        {
            System.out.println("... <Press enter> ...");
            Scanner keyboard= new Scanner(System.in);
            keyboard.nextLine();
        }

        /**
         * Clears the screen by writing several empty lines.
         */
        protected void clear()
        {
            for (int i = 0; i < 0; i++) {
                System.out.println();
            }
        }
    }


