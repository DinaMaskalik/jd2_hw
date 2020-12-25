<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<style>
  body {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-color: #2479b0;
    color: #E5E5E5;
    font-family: Lato, sans-serif;
  }

  h1 {
    margin: 10px 0;
  }
  p{
      margin: 5px 0;
  }
  .form__wrapper {
    width: 400px;
    height: 300px;
    padding: 20px;
    margin: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: #e09420;
    border-radius: 10px;
    margin-bottom: 10px;
  }

  form {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-bottom: 0;
  }
  input {
    border: 0;
    outline: 0;
    width: 100%;
    padding: 10px 20px;
    border-radius: 10px;
    margin: 5px;
  }

  button {
    border: none;
    outline: 0;
    padding: 10px 20px;
    border-radius: 10px;
    color: #000000;
    background-color: #ec9d6e;
    margin: 5px;
  }
</style>

<body>
    <div class="form__wrapper">
        <h1>Parallelepiped</h1>
        <form action="?command=para" method="post">
            <input type="text" name="length" placeholder="Length">
            <input type="text" name="width" placeholder="Width">
            <input type="text" name="height" placeholder="Height">
            <button type="submit">Calculate</button>
        </form>
        <p>Answer = ${paraAnswer}</p>
    </div>
    <div class="form__wrapper">
        <h1>Cube</h1>
        <form action="?command=cube" method="post">
            <input type="text" name="side" placeholder="Length">
            <button type="submit">Calculate</button>
        </form>
        <p>Answer = ${cubeAnswer}</p>
    </div>
     <div class="form__wrapper">
        <h1>Sphere</h1>
        <form action="?command=sphere" method="post">
            <input type="text" name="radius" placeholder="Radius">
            <button type="submit">Calculate</button>
        </form>
        <p>Answer = ${sphereAnswer}</p>
     </div>
</body>

</html>
