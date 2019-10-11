class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counters: [0]
    }

    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(state => ({
      counters: [...state.counters, state.counters.length]
    }))
  }

  render() {
    console.log(this.state)
    return (
      <div className="container">
        <button onClick={this.handleClick}>Add Counter</button>
        {this.state.counters.map(num => (
          <Counter key={num}/>
        ))}
      </div>
    )
  }
}

class Counter extends React.Component {
  constructor() {
    super();
    this.state = {
      count: 0
    }

    this.handleDecrement = this.handleDecrement.bind(this);
    this.handleIncrement = this.handleIncrement.bind(this);
  }

  handleIncrement() {
    this.setState(state => ({
      count: state.count + 1
    }))
  }

  handleDecrement() {
    this.setState(state => ({
      count: state.count - 1
    }))
  }


  render() {
    return (
      <div className="counter">
        <h1>{this.state.count}</h1>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>
      </div>
    )
  }
}
ReactDOM.render(
  <App />,
  document.getElementById('root')
)