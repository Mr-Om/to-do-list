import React, { useState, useEffect } from 'react';
import DeleteIcon from '@material-ui/icons/Delete';
import "./ListItem.css"

function ListItems({ todoitem, emit }) {
    const [todoItem, settodoItem] = useState(todoitem);
    const [dirty, setdirty] = useState(false);
    const handleChange = () => {
        setdirty(true);
        settodoItem({ ...todoItem, isDone: (1 - todoItem.isDone) });
    }

    useEffect(() => {
        if (dirty) {
            fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`,
                {
                    method: "PUT",
                    headers: {
                        "content-type": "application/json",
                    },
                    body: JSON.stringify(todoItem)
                }).then((updatedItem) => updatedItem.json())
                .then((u_item) => {
                    setdirty(false);
                    settodoItem(u_item)
                });
        }
    }, [todoItem, dirty])

    const handleChangeOnListName = (e) => {
        setdirty(true);
        settodoItem({ ...todoItem, task: e.target.value });
    }

    const deleteItem = () => {
        fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`,
            {
                method: "DELETE",
                headers: {
                    "content-type": "application/json",
                },
            })
            .then(() => {
                emit(todoItem);
            });
    }



    return (
        <div>
            <input class="check" type="checkbox" checked={todoItem.isDone === 1 ? true : false} onChange={handleChange} />{" "}
            {
                (todoItem.isDone === 1) ? <span class="checktext" className="checked">{todoItem.task}</span> : <input class="checktext" type="text" value={todoItem.task} onChange={handleChangeOnListName} />
            }
            <DeleteIcon className="recycle-bin" onClick={deleteItem}></DeleteIcon>
        </div>
    )
}

export default ListItems
