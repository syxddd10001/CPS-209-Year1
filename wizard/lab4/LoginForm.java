/**
  This class simulates a LoginForm for a user. The user can then enter text as
  input to the "input" method. This should take in the username and password on
  successive calls, and store these values. When the user clicks "Submit", the
  user should be logged in if their name and password were correct. If the user
  clicks "Reset", the user should be logged out.

  You should complete the following:
  - Complete the "method" that gets and stores the username and password, when
    called by successive calls
  - Complete the "checkLogin" method which checks if the username and password
    are correct
  - Complete the "click" method, which corresponds to the user clicking Submit
    or Reset

  This class is tested by LoginFormTester.java, which will also help you further
  understand the method definitions.
*/
public class LoginForm
{
   private String username;
   private String password;

   private String currentUsername;
   private String currentPassword;

   private boolean logged;
   private boolean firstInput;

   /**
      Setup a new login form.
   */
   public LoginForm(String username, String password)
   {
      this.username = username;
      this.password = password;
      reset();
   }

   // Uses text parameter and sets the current username and current password 
   public void input(String text)
   {
  	  //-----------Start below here. To do: approximate lines of code = 5
  	  // if this is the first input (Hint: use the firstInput variable) , must be the username so set currentUsername = text 
  	  // and set firstInput to false. Otherwise, must be the password so set currentPassword
  	  
  	   if (firstInput){
         currentUsername = text;
         firstInput = false;
      }
     
      else currentPassword = text;
      
  	  
 	  
  	  
  	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   private boolean checkLogin()
   {
  	  //-----------Start below here. To do: approximate lines of code = 5
  	  // if username not equal to currentUsername, return false
  	  // if password not equal to currentPassword return false
  	  // otherwise return true 
  	  
  	   if (username != currentUsername) return false;
      if (password != currentPassword) return false;


      return true;
  	  
  	  
  	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   // Called after user enters username and password
   // button parameter is either "Submit" or "Reset"
   public void click(String button)
   {
  	  //-----------Start below here. To do: approximate lines of code = 7
  	  // if button is "Submit" then 
  	  //         call checkLogin()
  	  //         if checkLogin() returns true, set logged to true 
  	  //         else call reset()
  	  //       else if button equals "Reset"
  	  //         call reset()
  	  
      if (button.equals("Submit")){
         checkLogin();
         if (checkLogin()) logged = true;
         else reset();
      }

      else if (button.equals("Reset")) reset();
  	  
  	  
  	  
  	  
  	  
  	  
  	  
  	  
  	  
  	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   private void reset()
   {
      currentUsername = "";
      currentPassword = "";
      logged = false;
      firstInput = true;
   }

   public boolean loggedIn()
   {
      return logged;
   }
}
