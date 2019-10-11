var rows = 8;
function numberOfRows(event) {
  event.preventDefault();
  rows = parseInt(document.getElementById('rows').value);
  ReactDOM.render(CheckerBoard(rows), document.getElementById("app"))
}

function CheckerBoard(props) {
  let rows = [];
  for (let i=1; i<=props; i++) {
    if (i % 2 == 0) {
      rows.push(Row({colorA: "black", colorB: "red", rows: props}));
    } else {
      rows.push(Row({colorA: "red", colorB: "black", rows: props}));
    }
  }
  return React.createElement('div', null, rows);
}

function Row(props) {
  let cells = [];
  for (let i=1; i<=props.rows; i++) {
    if (i % 2 == 0) {
      cells.push(Cell(props.colorA));
    } else {
      cells.push(Cell(props.colorB));
    }
  }
  console.log(cells);
  return React.createElement('ul', {style: {height: '20px', margin: 0}}, cells)
}

function Cell(props) {
  return React.createElement('li', {style: {height: '20px', width: '20px', display:'inline-block', backgroundColor: props}}, '')
}

ReactDOM.render(CheckerBoard(rows), document.getElementById("app"))

