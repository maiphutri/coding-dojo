const Voting = (props) => {
  return (
    <div className="container">
      <h1>Vote Your {props.name} Library!</h1>
      <List languages={props.languages}/>
    </div>
  )
}

const List = (props) => {
  return (
    <ul className="languages">
      {props.languages.map(language => <Language language={language}/>)}
    </ul>
  )
}

class Language extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      vote: 0
    }
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(state => ({
      vote: state.vote + 1
    }))
  }

  render() {
    return (
      <li className="language-row">
        <div>{this.state.vote}</div> <div>{this.props.language}</div> <button onClick={this.handleClick}>Vote</button>
      </li>
    )
  }
}

ReactDOM.render(
  <Voting languages={['React', 'Vue', 'Angular', 'Ember']}/>,
  document.getElementById('root')
)