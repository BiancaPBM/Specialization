import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import { Location } from '@angular/common';
import {DoctorService} from '../doctors/doctor.service';
import {ParamMap} from '@angular/router';
import { switchMap } from 'rxjs/operators';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-specific-doctor',
  templateUrl: './specific-doctor.component.html',
  styleUrls: ['./specific-doctor.component.css']
})
export class SpecificDoctorComponent implements OnInit {
  currentDoctor = null;
  message = '';
  constructor(
      private activatedRoute: ActivatedRoute,
      private router: Router,
      private doctorService: DoctorService
  ){}

  getDoctor(id) {
    this.doctorService.get(id)
        .subscribe(
            data => {
              this.currentDoctor = data;
              console.log(data);
            },
            error => {
              console.log(error);
            });
  }

  ngOnInit(): void {
    this.message = '';
    this.getDoctor(this.activatedRoute.snapshot.paramMap.get('id'));

  }
}
