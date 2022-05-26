const getData = async()=>{
  let url = `http://localhost:8080/Parcial2/Votaciones/Eleccion/CandidatosPresidenciales`;
  let response = await fetch(url, {method:'GET'} );
  let obj = await response.json();
  const names = [obj[0].president, obj[1].president, obj[2].president, obj[3].president, obj[4].president,obj[5].president,obj[6].president,obj[7].president,obj[8].president];
  return names;
}

const getDataVotes = async()=>{
  let url = `http://localhost:8080/Parcial2/Votaciones/Eleccion/CandidatosPresidenciales`;
  let response = await fetch(url, {method:'GET'} );
  let obj = await response.json();
  const votes = [obj[0].amountVotes, obj[1].amountVotes, obj[2].amountVotes, obj[3].amountVotes, obj[4].amountVotes, obj[5].amountVotes,obj[6].amountVotes,obj[7].amountVotes,obj[8].amountVotes];
  return votes;
}


const loadChart = async()=>{
  let labelsData = await getData();
  console.log(labelsData);

  let dataNumbers = await getDataVotes();
  console.log(dataNumbers);

  const data = {
      labels: labelsData,
      datasets: [{
          label: labelsData,
          data: dataNumbers,
          backgroundColor: [
              "#FFFF00",
              "#40E0D0",
              "#FFA500",
              "#FF0000",
              "#FF6384",
              "#2677BD",
              "#84FF63",
              "#8463FF",
              "#474747"

          ],
          borderColor: [
            "#FFFF00",
            "#40E0D0",
            "#FFA500",
            "#FF0000",
            "#FF6384",
            "#2677BD",
            "#84FF63",
            "#8463FF",
            "#474747"
          ],
          borderWidth: 2
      }]
  }

  const config = {

      type: 'doughnut',
      data,
      options: {
          tooltips: {
              enabled: true
          },
          plugins: {
              datalabels: {
                  formatter: (dataNumbers, chart) => {

                      let sum = 0;
                      let dataArr = chart.chart.data.datasets[0].data;
                      dataArr.map(data => {
                          sum += data;
                      });
                      let percentage = (dataNumbers * 100 / sum).toFixed(2) + "%";
                      return percentage;


                  },
                  color: '#000000',
              }
          }
      }

  };

  const myChart = new Chart(
      document.getElementById('myChart'),config

  );

}

loadChart();