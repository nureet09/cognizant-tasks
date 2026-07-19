import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
    const cohortsData = [
        {
            id: 'INTADMDF10',
            title: '.NET FSD',
            startDate: '22-Feb-2022',
            status: 'Scheduled',
            coach: 'Aathma',
            trainer: 'Jojo Jose'
        },
        {
            id: 'ADM21JF014',
            title: 'Java FSD',
            startDate: '10-Sep-2021',
            status: 'Ongoing',
            coach: 'Apoorv',
            trainer: 'Elisa Smith'
        },
        {
            id: 'CDBJF21025',
            title: 'Java FSD',
            startDate: '24-Dec-2021',
            status: 'Ongoing',
            coach: 'Aathma',
            trainer: 'John Doe'
        }
    ];

    return (
        <div style={{ padding: '30px', textAlign: 'center' }}>
            <h1 style={{ textAlign: 'left', marginLeft: '10px' }}>Cohorts Details</h1>
            <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start' }}>
                {cohortsData.map((cohort, index) => (
                    <CohortDetails 
                        key={index}
                        id={cohort.id}
                        title={cohort.title}
                        startDate={cohort.startDate}
                        status={cohort.status}
                        coach={cohort.coach}
                        trainer={cohort.trainer}
                    />
                ))}
            </div>
        </div>
    );
}

export default App;