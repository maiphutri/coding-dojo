import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor() {
    super();
    this.state = {
      items: JSON.parse(localStorage.getItem('items')) || [],
      filter: 'all',
      newTask: ""
    }
  }

  handleChange(e) {
    this.setState({newTask: e.target.value})
  }

  handleTaskComplete(e) {
    console.log(e.target.checked)
    const updateItemList = this.state.items.map(item => (
      item.id == e.target.value ? {...item, completed: e.target.checked} : item
    ))
    this.setState({items: updateItemList}, () => {
      localStorage.setItem("items", JSON.stringify([...this.state.items]))
    })
    
  }

  handleClick(e) {
    this.setState({filter: e.target.innerText.toLowerCase()})
  }

  handleDelete(e) {
    const updateItemList = this.state.items.filter(item => item.id !== parseInt(e.target.id));
    this.setState({items: updateItemList}, () => {
      localStorage.setItem("items", JSON.stringify([...this.state.items]))
    })

  }

  handleSubmit(e) {
    e.preventDefault();
    const newItem = {
      id: this.state.items.length + 1 || 1,
      text: this.state.newTask,
      completed: false
    };
    this.setState(state => ({
      items: [...state.items, newItem]
    }));
    localStorage.setItem("items", JSON.stringify([...this.state.items, newItem]));
  }
  render() {
    let list = this.state.items;

    if (this.state.filter === "completed") {
      list = this.state.items.filter(item => item.completed)
    }

    if (this.state.filter === "active") {
      list = this.state.items.filter(item => !item.completed)
    }

    return (
      <div className="container">
        <h1>todos</h1>
        <div className="task-container">
          <form onSubmit={(e) => this.handleSubmit(e)} className="form">
            <input 
              className="task-input" 
              type="text" 
              placeholder="What need to be done?" 
              onChange={(e) => this.handleChange(e)}
            />
          </form>
          <ul className="list-task">
            {list.map(item => (
              <li className="taskRow" key={item.id} >
                <input type="checkbox" className="checkbox" onChange={(e) => this.handleTaskComplete(e)} value={item.id} checked={item.completed}/>
                <span className={item.completed ? 'completed' : ""}>{item.text}</span>
                <span className="close" onClick={(e) => this.handleDelete(e)} id={item.id}>&#x274C;</span>
              </li>
            ))}
          </ul>
          <footer className="footer">
            <span className="items-left">{this.state.items.length} items left</span>
            <button onClick={(e) => this.handleClick(e)} >All</button>
            <button onClick={(e) => this.handleClick(e)} >Active</button>
            <button onClick={(e) => this.handleClick(e)} >Completed</button>
          </footer>
        </div>
      </div>
    );
  }
}

export default App;
