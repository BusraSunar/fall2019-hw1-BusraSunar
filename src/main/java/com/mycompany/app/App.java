<title>My application deployed automatically</title>
  <h1>Hello, World!</h1>
  <strong>
    In the first form, enters a list of integers seperated by a new line character.<br>
    In the second form, enter another integer.<br>
    If this integer is found in the list, the result becomes true.<br>
    In the third form, enters a list of integers seperated by a new line character.<br>
    In the fourth form, enters an operator signal. <br>
    Then the second result is computed according to the given operator. <br>
  </strong>
  <br>
    Result is {{result}}<br>
    {{result2}}
  <form action="compute" method="post">
        <textarea name="input1" rows="10" cols="20" placeholder="int list 1"></textarea>
        <textarea name="input2" rows="10" cols="20" placeholder= "search integer"></textarea>
        <textarea name="input3" rows="10" cols="20" placeholder="int list 2"></textarea>
        <textarea name="input4" rows="10" cols="20" placeholder="+ or - or *"></textarea>
        <br>
        <input type="submit">
  </form>
