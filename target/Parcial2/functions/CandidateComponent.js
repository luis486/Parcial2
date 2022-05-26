class CandidateComponent{

    constructor(person){
        this.person=person;
    }

    render(container){

        let html=`<div class="card-group">
        <div class="card text-center" style="width: 24rem;">
        <img src="${this.person.groupImage}" class="card-img-top" alt="..." width="400px" height="400px">
        <div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
      <img src="${this.person.presidentImage}" class="card-img-top" alt="..."  width="150px" height="150px">
      <h7 class="card-title"><b> PRESIDENTE</b><br>${this.person.president}</h7>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
      <img src="${this.person.viecepresidentImage}" class="card-img-top" alt="..." width="150px" height="150px">
      <h7 class="card-title"><b> VICEPRESIDENTE</b><br>${this.person.formula}</h7>
      </div>
    </div>
  </div>
</div>
        <a href="#" id="button${this.person.id}" class="btn btn-primary">VOTAR</a>
        
        </div>
      </div>`;

        if (this.person.president=="VOTO EN BLANCO"){
        html=`<div class="card-group">
        <div class="card text-center" style="width: 24rem;">
        <img src="${this.person.presidentImage}" class="card-img-top" alt="..." width="400px" height="400px">
        <div class="card-body">
            <h3 class="card-title align-center">VOTO EN BLANCO</h3>
            </div>
        <a href="#" id="button${this.person.id}" class="btn btn-primary">VOTAR</a>
        
        </div>
      </div>`;

        }
        let root = document.createElement('div');
        root.innerHTML = html.trim();
        container.appendChild(root.firstChild);

        let button = document.getElementById(`button${this.person.id}`);
        button.addEventListener('click',this.action.bind(this)); 
    }

    action=async(event)=>{
        event.preventDefault();
        let xhr = new XMLHttpRequest();
        let url = `http://localhost:8080/Parcial2/Votaciones/CandidatosPresidenciales/Resultados`;
        xhr.open('PUT',url);
        xhr.setRequestHeader('Content-Type','application/json');
        xhr.send(JSON.stringify(this.person));

        window.alert('Voto registrado');
        window.location.href = "results.html";
    }    
}