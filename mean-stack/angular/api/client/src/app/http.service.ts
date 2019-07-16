import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {
    this.getPokemonAbilities();
    this.shareAbilities();
  };

  getPokemonAbilities() {
    interface Data {
      abilities: any[],
      name: string
    }
    let pokemon = this._http.get<Data>("https://pokeapi.co/api/v2/pokemon/60");
    pokemon.subscribe(data => {
      let newString: string = `${data.name}'s abilities are `;
      for (let i in data.abilities) {
        if (parseInt(i) === (data.abilities.length - 1)) {
          newString += `and ${data.abilities[i].ability.name}.`;
          break;
        }
        newString += `${data.abilities[i].ability.name}, `;
      }
      console.log(newString);
      console.log(data);
    });
  }

  shareAbilities() {
    interface Data {
      pokemon: any[],
      name: string
    }
    let ability =  this._http.get<Data>("https://pokeapi.co/api/v2/ability/60");
    ability.subscribe(data => {
      console.log(data);
      console.log(`${data.pokemon.length} Pokemon have the ${data.name} ability.`);
    })
  }

}
