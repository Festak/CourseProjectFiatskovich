package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.ReportDao;
import Fiatskovich.modelFiatskovich.Report;
import Fiatskovich.serviceFiatskovich.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 22.02.2017.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    @Transactional
    public Set<Report> getAllReports() {
        Set<Report> set = new LinkedHashSet<Report>(reportDao.findAll());
        return set;
    }

    @Override
    public void makeReport(Report report) {
reportDao.save(report);
    }
}
