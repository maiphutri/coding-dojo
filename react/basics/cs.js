
ReactDOM.render(
  React.createElement('div', null, 
    React.createElement(
      'div', 
      {style: {
        width: '100px', 
        height: '100px', 
        backgroundColor: 'blue', 
        color: 'white',
        display: 'inline-block'
        }
      }, 
      'white on blue'),
    React.createElement(
      'div', 
      {style: {
        width: '100px', 
        height: '100px', 
        backgroundColor: 'red', 
        color: 'blue',
        display: 'inline-block'
        }
      }, 
      'blue on red'),
    React.createElement(
      'div', 
      {style: {
        width: '100px', 
        height: '100px', 
        backgroundColor: 'pink', 
        color: 'green',
        display: 'inline-block'
        }
      }, 
      'green on pink')
  )
  ,document.getElementById("app")
)