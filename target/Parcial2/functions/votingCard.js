const candidateContainer = document.getElementById('candidateComponent');

const getCandidates = async()=>{
   let url = `http://localhost:8080/Parcial2/Votaciones/Eleccion/CandidatosPresidenciales`;
   let response = await fetch(url, {method:'GET'} );
   let obj = await response.json();

   for(let  i in obj){
       let candidate = new Candidate(obj[i].id,obj[i].president, obj[i].vicepresident, obj[i].presidentImage, obj[i].vicepresidentImage, obj[i].groupImage,obj[i].amountVotes);
       let component = new CandidateComponent(candidate);
       component.render(candidateContainer);
   }
}

getCandidates();