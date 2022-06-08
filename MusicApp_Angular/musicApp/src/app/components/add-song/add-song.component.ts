import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-song',
  templateUrl: './add-song.component.html',
  styleUrls: ['./add-song.component.css']
})
export class AddSongComponent implements OnInit {

  public form: FormGroup;
  public mainForm: FormGroup;
  rating3: number;

  constructor(private fb: FormBuilder){
    this.rating3 = 0;
    this.form = this.fb.group({
      rating: ['', Validators.required],
    })

    this.mainForm = this.fb.group({
      songname: ['', Validators.required],
      releaseDate: ['', Validators.required],
      rating: ['', Validators.required]
    })
    
  }
  
  ngOnInit(): void {
  }

}
