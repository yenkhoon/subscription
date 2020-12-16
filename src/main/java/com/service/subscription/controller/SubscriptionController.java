package com.service.subscription.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.service.subscription.dto.PostSubscriptionDTO;
import com.service.subscription.dto.ResponseSubscriptionDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.ZoneId;

@RestController
@RequestMapping("/subscribe")
public class SubscriptionController {

    @PostMapping("/")
    public ResponseEntity<?> subcription(@RequestBody PostSubscriptionDTO subs) {

        String subType = subs.getSubType().toUpperCase();
        List<String> invoiceDates = new ArrayList<String>();
        Date subDate = subs.getSubDate();

        if (!subType.equals("DAILY") && !subType.equals("WEEKLY") && !subType.equals("MONTHLY")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (subType.equals("DAILY")) {
            Calendar c = Calendar.getInstance();
            c.setTime(subDate);

            // Note: Maximum 3 months subscription
            c.add(Calendar.MONTH, 3);

            // Note: Convert calendar to date
            Date futureDate = c.getTime();

            LocalDate startDate = LocalDate.ofInstant(subDate.toInstant(), ZoneId.systemDefault());
            LocalDate endDate = LocalDate.ofInstant(futureDate.toInstant(), ZoneId.systemDefault());

            long days = ChronoUnit.DAYS.between(startDate, endDate);
            System.out.println(days);
            for (long i = 0; i < days; i++) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(subDate);
                cal.add(Calendar.DATE, (int) i);
                Date invoiceDate = cal.getTime();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = format.format(invoiceDate);

                invoiceDates.add(formattedDate);
            }
        }

        if (subType.equals("WEEKLY")) {
            Calendar c = Calendar.getInstance();
            c.setTime(subDate);

            // Note: Maximum 3 months subscription
            c.add(Calendar.MONTH, 3);

            // Note: Convert calendar to date
            Date futureDate = c.getTime();

            LocalDate startDate = LocalDate.ofInstant(subDate.toInstant(), ZoneId.systemDefault());
            LocalDate endDate = LocalDate.ofInstant(futureDate.toInstant(), ZoneId.systemDefault());

            long weeks = ChronoUnit.WEEKS.between(startDate, endDate);

            for (long i = 0; i < weeks; i++) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(subDate);
                cal.add(Calendar.WEEK_OF_MONTH, (int) i);
                Date invoiceDate = cal.getTime();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = format.format(invoiceDate);

                invoiceDates.add(formattedDate);
            }
        }

        if (subType.equals("MONTHLY")) {
            Calendar c = Calendar.getInstance();
            c.setTime(subDate);

            // Note: Maximum 3 months subscription
            c.add(Calendar.MONTH, 3);

            // Note: Convert calendar to date
            Date futureDate = c.getTime();

            LocalDate startDate = LocalDate.ofInstant(subDate.toInstant(), ZoneId.systemDefault());
            LocalDate endDate = LocalDate.ofInstant(futureDate.toInstant(), ZoneId.systemDefault());

            long months = ChronoUnit.MONTHS.between(startDate, endDate);

            for (long i = 0; i < months; i++) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(subDate);
                cal.add(Calendar.MONTH, (int) i);
                Date invoiceDate = cal.getTime();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = format.format(invoiceDate);

                invoiceDates.add(formattedDate);
            }
        }

        ResponseSubscriptionDTO res = new ResponseSubscriptionDTO();
        res.setAmount(subs.getAmount());
        res.setSubType(subs.getSubType());
        res.setInvoiceDates(invoiceDates);

        return new ResponseEntity<ResponseSubscriptionDTO>(res, HttpStatus.OK);

    }
}
