import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,FormControl,Validators} from '@angular/forms';
import { Location } from "@angular/common";
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-add-details',
  templateUrl: './add-details.component.html',
  styleUrls: ['./add-details.component.css']
})
export class AddDetailsComponent implements OnInit {
  adForm : FormGroup;
  submitted : boolean = false;
  addid : any = [];
  Details ;

  constructor(
    private formBuilder: FormBuilder, 
    private locate : Location,
    private commonService: CommonService) { 
    // this.addid = [];
    // this.addid.id = this._student.getStudDeatails().length+1;
    // this.Details = this._student.getStudDeatails();
  }

  ngOnInit() {
    this.Inziling();
    // this.addValues();
  }

  Inziling(){
    this.adForm =  this.formBuilder.group({
      adId : new FormControl('', Validators.required),
      adName : new FormControl('', Validators.required),
      adDescription : new FormControl('',Validators.required),
      Type :  new FormControl('', Validators.required),
      Email : new FormControl('', Validators.required)
      // startDate :  new FormControl('',Validators.required),
      // EndDate :  new FormControl('', Validators.required)
    });
  }

  // addValues(){
  //   this.adForm.controls["StudentId"].setValue(this.addid.id =+this.addid.id);
  //   this.addid =[];
  // }

  Cancel(){
    this.locate.back();
  }

  get f() { return this.adForm.controls; }

  onSubmit() {
    this.submitted = true;
    console.log(this.adForm.value,"Value");

    if(this.adForm.valid){
      alert("OK");
      this.commonService.createAdvertisment(this.adForm.value).subscribe(res=>{
        console.log(res)
      })
    }
  }

}
