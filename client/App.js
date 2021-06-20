import react, { useEffect, useState } from 'react';
import './App.css';
import ListItems from "./components/ListItems";
import Button from '@material-ui/core/Button';

function App() {
  const [todoItems, settodoItems] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8080/api/todoItems")
      .then((response) => response.json())
      .then(todoItems => {
        console.log(todoItems);
        settodoItems(todoItems);
      })

  }, [])

  const addNewTodoItems = () => {
    fetch("http://localhost:8080/api/todoItems", {
      headers: {
        'content-type': 'application/json'
      },
      method: "POST"
    }).then(rawNewItem => rawNewItem.json()).then(newItem => settodoItems([...todoItems, newItem]));
  }
  const handleDelete = (item) => {
    const updatedArray = todoItems.filter((each_item) => each_item.id !== item.id);
    settodoItems(updatedArray);
  }
  return <div class="parent">
    <div class="list__container">
      <Button className="button" variant="contained" color="primary" onClick={addNewTodoItems}>Add New Item</Button>
      {/* <button onClick={addNewTodoItems}>Add New Item</button> */}
      {todoItems.map((todoitem) => {
        return <ListItems key={todoitem.id} todoitem={todoitem} emit={handleDelete}></ListItems>
      })}
    </div>
  </div>
}

export default App;
